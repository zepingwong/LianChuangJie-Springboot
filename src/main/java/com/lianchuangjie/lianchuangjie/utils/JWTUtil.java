package com.lianchuangjie.lianchuangjie.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lianchuangjie.lianchuangjie.exception.Token.TokenError;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Objects;


public class JWTUtil {
    /**
     * @description 密码令牌 鉴权 相当于私钥保存在服务器上
     */
    private  static  final String  SECRET="##@$%@#S#WS";

    /**
     * @description 令牌前缀
     */
    private static final  String TOKEN_PREFIX = "token";

    /**
     * @description 令牌过期时间
     */
    private static final Integer EXPIRE_SECONDS = 60 * 60 * 24 * 7; // 以秒计，目前设置为7天

    /**
     * @description 生成 token
     * @param map token payload
     * @return token
     */
    public static String generateToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        // payload
        map.forEach(builder::withClaim);
        // expire time
        builder.withExpiresAt(DateUtil.offsetSecond(new Date(), EXPIRE_SECONDS));
        return TOKEN_PREFIX + "_" + builder.sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * @description token 验证
     * @param token token
     * @return Boolean Value
     */
    public static Map<String, Claim> verifyToken(String token) {
        TokenError.ISNULL.assertNotNull(token);
        try {
            return JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(Objects.requireNonNull(token).replaceFirst(TOKEN_PREFIX + "_", ""))
                    .getClaims();
        } catch (SignatureVerificationException ex) {
            throw TokenError.TOKEN_SIGNATURE.newException(ex.getMessage());
        } catch (TokenExpiredException ex) {
            throw TokenError.TOKEN_EXPIRED.newException(ex.getMessage());
        } catch (AlgorithmMismatchException ex) {
            throw TokenError.TOKEN_ALGORITHM_MISMATCH.newException(ex.getMessage());
        } catch (Exception ex) {
            throw TokenError.TOKEN_ERROR.newException(ex.getMessage());
        }
    }
}
