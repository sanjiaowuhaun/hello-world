package cn.smbms.service.bill;


import cn.smbms.dao.bill.BillMapper;
import cn.smbms.pojo.Bill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("billService")
public class BillServiceImpl implements BillService {
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    private BillMapper billMapper;

    @Override
    public boolean add(Bill bill) {
        return billMapper.addBill(bill) > 0;
    }

    @Override
    public List<Bill> getBillList(Bill bill) {
        logger.info("query productName ---- > " + bill.getProductName());
        logger.info("query providerId ---- > " + bill.getProviderId());
        logger.info("query isPayment ---- > " + bill.getIsPayment());
        return billMapper.getBillList(bill);
    }

    @Override
    public boolean deleteBillById(int delId) {
        return billMapper.deleteBillById(delId) > 0;
    }

    @Override
    public Bill getBillById(int id) {
        return billMapper.getBillById(id);
    }

    @Override
    public boolean modify(Bill bill) {
        return billMapper.modifyBill(bill) > 0;
    }
}
