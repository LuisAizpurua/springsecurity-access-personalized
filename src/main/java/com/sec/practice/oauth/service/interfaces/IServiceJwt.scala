package com.sec.practice.oauth.service.interfaces

import com.sec.practice.oauth.persistence.entities.sec.User

import java.util
import javax.crypto.SecretKey

trait IServiceJwt {

  def generateJwt(userdto: User): String

  def generateClaims(user: User): util.Map[String, Object]

  def generateKey: SecretKey
}
