package br.com.udemy.data.transform;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerTransform {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static<O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}
	
	public static<O, D> List<D> parseListObject(List<O> origin, Class<D> destination){
		List<D> destinationObject = new ArrayList<D>();
		for (Object obj : origin) {
			destinationObject.add(mapper.map(obj, destination));
		}
		return destinationObject;
	}
}
