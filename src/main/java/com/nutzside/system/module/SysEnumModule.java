package com.nutzside.system.module;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.nutzside.common.domain.ResponseData;
import com.nutzside.common.domain.jqgrid.JqgridReqData;
import com.nutzside.system.domain.SysEnum;
import com.nutzside.system.domain.SysEnumItem;
import com.nutzside.system.service.SysEnumItemService;
import com.nutzside.system.service.SysEnumService;

@IocBean
@At("/system/sysEnum")
public class SysEnumModule {

	@Inject
	private SysEnumService sysEnumService;
	@Inject
	private SysEnumItemService sysEnumItemService;

	@At
	@RequiresPermissions("sysenum:read:*")
	public ResponseData getSysEnumGridData(@Param("..") JqgridReqData jqReq, @Param("_search") Boolean isSearch,
			@Param("..") SysEnum sysEnumSearch) {
		return sysEnumService.getGridData(jqReq, isSearch, sysEnumSearch);
	}

	@At("/getSysEnumItemGridData/*")
	@RequiresPermissions("sysenum:read:*")
	public ResponseData getSysEnumItemGridData(@Param("..") JqgridReqData jqReq, @Param("_search") Boolean isSearch,
			@Param("..") SysEnumItem sysEnumItemSearch) {
		return sysEnumItemService.getGridData(jqReq, isSearch, sysEnumItemSearch);
	}

	@At
	@RequiresPermissions("sysenum:create, delete, update:*")
	public ResponseData editSysEnum(@Param("oper") String oper, @Param("ids") String ids, @Param("..") SysEnum sysEnum) {
		return sysEnumService.CUDSysEnum(oper, ids, sysEnum);
	}

	@At
	@RequiresPermissions("sysenum:create, delete, update:*")
	public ResponseData editSysEnumItem(@Param("oper") String oper, @Param("ids") String ids,
			@Param("..") SysEnumItem sysEnumItem) {
		return sysEnumItemService.CUDSysEnumItem(oper, ids, sysEnumItem);
	}
	
	@At
	@Ok("httl:system.sysenum_mange")
	@RequiresPermissions("httl:read:sysenum_mange")
	public void sysenum_mange() {
	}
	
}