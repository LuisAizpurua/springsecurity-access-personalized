package com.sec.practice.oauth.exceptions

class NotExistsEntity(msg: String) extends RuntimeException(msg){

  def this()={
    this("")
  }
  def getMesg(id: Long, tclass: Class[_] ): NotExistsEntity = {
    new NotExistsEntity(s"The entity ${tclass.getName} with id '$id' not exists")
  }
}
