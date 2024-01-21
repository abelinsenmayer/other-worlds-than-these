package abe.owtt

import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun makeLogger(clazz : Any): Logger = LoggerFactory.getLogger("owtt:${clazz::class.java}")