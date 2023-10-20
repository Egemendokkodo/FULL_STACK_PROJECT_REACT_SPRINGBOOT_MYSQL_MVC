package com.backend_sign_in_sign_up.sign_in_up_restapi.exception;

public class EmailNotFoundException extends RuntimeException{
    
        private static final long serialVersionUID=1L;
        private String resourceName;
        private String fieldName;
        private Object fieldValue;
        public EmailNotFoundException(String resourceName, String fieldName, Object fieldValue) {
            super(String.format("%s email not found %s : '%s' ",resourceName,fieldName,fieldValue));
            this.resourceName = resourceName;
            this.fieldName = fieldName;
            this.fieldValue = fieldValue;
        }
    
    
        public String getResourceName() {
            return resourceName;
        }
        public String getFieldName() {
            return fieldName;
        }
        public Object getFieldValue() {
            return fieldValue;
        }
    
}