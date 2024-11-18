package com.sec.practice.oauth.exceptions

class NotExists(msg: String) extends RuntimeException(msg){

  def this()={
    this("")
  }
}
