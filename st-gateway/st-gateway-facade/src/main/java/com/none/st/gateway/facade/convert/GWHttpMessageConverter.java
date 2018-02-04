package com.none.st.gateway.facade.convert;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GWHttpMessageConverter extends MappingJackson2HttpMessageConverter{
	private List<String> ignoreUrlList;
	private static Logger logger = LoggerFactory.getLogger(GWHttpMessageConverter.class);

	@Override
	public Object read( Type type, Class<?> contextClass, HttpInputMessage inputMessage ) throws IOException,
			HttpMessageNotReadableException {
//		ServletServerHttpRequest httpRequest = (ServletServerHttpRequest)inputMessage;
		JavaType javaType = getJavaType( type, contextClass );
		Object obj = readJavaType( javaType, inputMessage );
//		String uri=httpRequest.getServletRequest().getRequestURI();
//		String path=uri.substring(uri.indexOf("/",2), uri.length());
/*		JSONObject json= JSONObject.parseObject(obj.toString());
		Boolean b=TokenUtil.checkToken(json.getLong("accountNo"),json.getString("token"));
		tl.set(b);*/
		if(logger.isDebugEnabled()){
			logger.debug("convert json to javaObject:{}",obj);
		}
		return obj;
	}
	
	@Override
	public void writeInternal(Object object, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		ObjectMapper mapper=new ObjectMapper();
		String msg=mapper.writeValueAsString(object);
		if(logger.isDebugEnabled()){
			logger.debug("convert javaObject to jsonstring:{}",msg);
		}
		super.writeInternal(object, outputMessage);
	}
	private Object readJavaType(JavaType javaType, HttpInputMessage inputMessage) {
		try {
			return new ObjectMapper().readValue(inputMessage.getBody(), javaType);
		}
		catch (IOException ex) {
			throw new HttpMessageNotReadableException("Could not read JSON: " + ex.getMessage(), ex);
		}
	}
	@Override
	public ObjectMapper getObjectMapper(){
		ObjectMapper objectMapper=new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		return objectMapper;
	}

	public List<String> getIgnoreUrlList() {
		return ignoreUrlList;
	}

	public void setIgnoreUrlList(List<String> ignoreUrlList) {
		this.ignoreUrlList = ignoreUrlList;
	}
}
