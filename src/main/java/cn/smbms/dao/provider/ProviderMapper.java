package cn.smbms.dao.provider;

import cn.smbms.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.sql.Connection;
import java.util.List;

public interface ProviderMapper {
	
	/**
	 * 增加供应商
	 * @param provider
	 * @return
	 */
	 int addProvider(Provider provider);


	/**
	 * 通过供应商名称、编码获取供应商列表-模糊查询-providerList
	 * @param proName
	 * @param proCode
	 * @return List<provider>
	 */
	 List<Provider> getProviderList(@Param("proName") String proName,
                                    @Param("proCode") String proCode);

	/**
	 * 通过proId删除Provider
	 * @param delId
	 * @return
	 */
	 int deleteProviderById(@Param("id") Integer delId);


	/**
	 * 通过proId获取Provider
	 * @param id
	 * @return
	 */
	 Provider getProviderById(@Param("id") Integer id);

	/**
	 * 修改供应商信息
	 * @param provider
	 */
	 int modifyProvider(Provider provider);
	
	
}
