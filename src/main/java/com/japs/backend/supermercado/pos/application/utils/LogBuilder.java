package com.japs.backend.supermercado.pos.application.utils;

import com.japs.backend.supermercado.pos.application.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogBuilder {

    /*public static <T> void buildLog(String path, ApiResponse<T> apiResponse,RuntimeException runtimeException){
        if (path.contains("save")){
            create(path,apiResponse,runtimeException);
        }

        if (path.contains("update")){

        }

        if (path.contains("delete")){

        }

        if (path.contains("find-all")){

        }
    }

    public static <T> void create(String path, ApiResponse<T> apiResponse,RuntimeException runtimeException){

        if (path.contains("customer")){
            log.warn("warning al crear el cliente: {}", runtimeException.getMessage());
            log.warn("response create cliente: {}",apiResponse.toString());
            log.warn("Finalizo creación de cliente");
        }

    }*/

}
