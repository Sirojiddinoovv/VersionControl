package com.example.vc.config;


import com.example.vc.model.annotation.ApiVersion;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author: Nodir
 * @date: 27.07.2025
 * @group: Meloman
 **/

@Configuration
public class WebMVCConfig extends WebMvcConfigurationSupport {

    @Override
    @NonNull
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new ApiVersionRequestMappingHandlerMapping();
    }

    private static class ApiVersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
        @Override
        protected RequestMappingInfo getMappingForMethod(@NonNull Method method, @NonNull Class<?> handlerType) {
            RequestMappingInfo mapping = super.getMappingForMethod(method, handlerType);
            if (mapping == null) return null;

            ApiVersion apiVersion = method.getDeclaredAnnotation(ApiVersion.class);
            if (apiVersion == null) {
                apiVersion = handlerType.getDeclaredAnnotation(ApiVersion.class);
            }


            if (apiVersion != null) {
                String version = apiVersion.value();

                var originalPaths = mapping.getPatternValues();
                RequestMappingInfo versionedMapping = null;

                for (String path : originalPaths) {
                    String newPath = path.replaceFirst("^(/api)(/.*)?$", "$1/v" + version + "$2");
                    var singleMapping = RequestMappingInfo.paths(newPath).build();
                    versionedMapping = (versionedMapping == null) ? singleMapping : versionedMapping.combine(singleMapping);
                }

                return versionedMapping;
            }

            return mapping;
        }
    }
}
