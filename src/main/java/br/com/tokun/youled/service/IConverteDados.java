package br.com.tokun.youled.service;

public interface IConverteDados {
    <T>T obterDados(String json, Class<T> classe);

}
