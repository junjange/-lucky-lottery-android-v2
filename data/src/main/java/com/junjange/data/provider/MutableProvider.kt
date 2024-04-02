package com.junjange.data.provider

interface MutableProvider<T> : Provider<T> {
    override var value: T
}
