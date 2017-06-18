package dubbo.console;

 
import org.springframework.stereotype.Service;

import dubbo.api.TestRegistryService;

@Service("testRegistryService")
public class TestRegistryServiceImpl implements TestRegistryService {
	public String hello(String name) {
		return "hello" + name;
	}
} 