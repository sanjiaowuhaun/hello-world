package cn.smbms.service.bill;


import cn.smbms.pojo.Bill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BillServiceImplTest {
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private BillService billService = (BillService) ac.getBean("billService");

    @Test
    public void add() {
        Bill bill = new Bill();
        bill.setBillCode("********");
        bill.setProductName("&&&&&&&&&&");
//        boolean add = billService.add(bill);
        assertTrue(billService.add(bill));
//        logger.info("是否成功==》" + add);
    }

    @Test
    public void getBillList() {
        Bill bill = new Bill();
        bill.setProviderId(1);
        List<Bill> billList = billService.getBillList(bill);
        billList.stream().forEach(System.out::println);
//        for (Bill bill1 : billList) logger.info(bill1);
    }

    @Test
    public void deleteBillById() {
        boolean del = billService.deleteBillById(19);
        logger.info("是否删除成功==》 " + del);
    }

    @Test
    public void getBillById() {
        Bill bill = billService.getBillById(18);
        logger.info(bill);
    }

    @Test
    public void modify() {
        Bill bill = new Bill();
        bill.setId(20);
        bill.setProviderId(1);
        bill.setIsPayment(2);
        bill.setProductName("fruit");
        bill.setBillCode("123455");
        boolean modify = billService.modify(bill);
        logger.info(modify);
    }
}