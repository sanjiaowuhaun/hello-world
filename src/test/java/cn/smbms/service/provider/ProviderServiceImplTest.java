package cn.smbms.service.provider;


import cn.smbms.pojo.Provider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class ProviderServiceImplTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ProviderService providerService = (ProviderService) ac.getBean("providerService");
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Test
    public void add() {
        Provider provider = new Provider();
        provider.setCreatedBy(1);
        provider.setCreationDate(new Date());
        provider.setProAddress("红山湖");
        provider.setProContact("12222222222");
        provider.setProName("李明");
        provider.setProPhone("166666666666");
        boolean add = providerService.add(provider);
        logger.info(add);
    }

    @Test
    public void getProviderList() {
        List<Provider> providerList = providerService.getProviderList("李明", "");
        for (Provider provider : providerList) {
            logger.info(provider);
        }
    }

    @Test
    public void deleteProviderById() {
        int i = providerService.deleteProviderById(16);
        logger.info(i);
    }

    @Test
    public void getProviderById() {
        Provider provider = providerService.getProviderById(17);
        logger.info(provider);
    }

    @Test
    public void modify() {
        Provider provider = providerService.getProviderById(17);
        provider.setProCode("ureoqwerty");
        boolean modify = providerService.modify(provider);
        logger.info(modify);
    }
}