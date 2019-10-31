package cn.smbms.service.provider;


import cn.smbms.dao.bill.BillMapper;
import cn.smbms.dao.provider.ProviderMapper;
import cn.smbms.pojo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderMapper providerMapper;
    @Autowired
    private BillMapper billMapper;

    @Override
    public boolean add(Provider provider) {
        return providerMapper.addProvider(provider) > 0;
    }

    @Override
    public List<Provider> getProviderList(String proName, String proCode) {
        return providerMapper.getProviderList(proName, proCode);
    }

    /**
     * 业务：根据ID删除供应商表的数据之前，需要先去订单表里进行查询操作
     * 若订单表中无该供应商的订单数据，则可以删除
     * 若有该供应商的订单数据，则不可以删除
     * 返回值billCount
     * 1> billCount == 0  删除---1 成功 （0） 2 不成功 （-1）
     * 2> billCount > 0    不能删除 查询成功（0）查询不成功（-1）
     * <p>
     * ---判断
     * 如果billCount = -1 失败
     * 若billCount >= 0 成功
     */
    @Override
    public int deleteProviderById(int delId) {
        int billCount = billMapper.getBillCountByProviderId(delId);
        if (billCount == 0) {
            return providerMapper.deleteProviderById(delId);
        }
        return 0;
    }

    @Override
    public Provider getProviderById(int id) {
        return providerMapper.getProviderById(id);
    }

    @Override
    public boolean modify(Provider provider) {
        return providerMapper.modifyProvider(provider) > 0;
    }
}
