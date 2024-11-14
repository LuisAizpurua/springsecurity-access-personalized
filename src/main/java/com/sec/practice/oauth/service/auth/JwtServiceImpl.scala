package com.sec.practice.oauth.service.auth

import com.sec.practice.oauth.persistence.entities.sec.User
import com.sec.practice.oauth.persistence.repository.RepositoryUser
import com.sec.practice.oauth.service.interfaces.IServiceJwt
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

import java.util
import java.util.{Date, HashMap, Map, Optional}
import javax.crypto.SecretKey
import scala.collection.mutable
//import scala.jdk.CollectionConverters._
class JwtServiceImpl extends IServiceJwt{

  @Autowired private val repositoryUser: RepositoryUser = null
  @Autowired private val env: Environment = null
  override def generateJwt(userdto: User): String = {

    val issu: Date = new Date(System.currentTimeMillis)
    val exp: Date = new Date((System.currentTimeMillis * 60 * 100) + env.getProperty("minute.exp").asInstanceOf[Long])
    val jwt: String = Jwts.builder.header.`type`("JWT").add("alg", "HS256").and.subject(userdto.getUsername).claims(generateClaims(userdto)).issuedAt(issu).expiration(exp).signWith(generateKey).compact()

    jwt
  }

   override def generateClaims(user: User): util.Map[String, Object] = {
    val map: util.Map[String, Object] = mutable.Map[String, Object](
      "authorities" -> user.getAuthorities.asInstanceOf[Object], "password" -> user.getPassword.asInstanceOf[Object]
    ).asInstanceOf[util.Map[String, Object]]
    map
  }

  override def generateKey: SecretKey = {
    val bytes: Array[Byte] = Decoders.BASE64.decode(env.getProperty("key.jwt"))
    Keys.hmacShaKeyFor(bytes)
  }

}