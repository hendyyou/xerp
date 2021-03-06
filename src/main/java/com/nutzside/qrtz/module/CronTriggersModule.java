package com.nutzside.qrtz.module;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.nutzside.common.domain.ResponseData;
import com.nutzside.common.domain.jqgrid.JqgridReqData;
import com.nutzside.qrtz.domain.CronTriggers;
import com.nutzside.qrtz.service.CronTriggersService;

@IocBean
@At("/qrtz/cronTriggers")
public class CronTriggersModule {
	
	@Inject
	private CronTriggersService cronTriggersService;

	@At
	public ResponseData getGridData(@Param("..") JqgridReqData jqReq, @Param("_search") Boolean isSearch, @Param("..") CronTriggers cronTriggersSearch) {
		return cronTriggersService.getGridData(jqReq, isSearch, cronTriggersSearch);
	}
	
	@At
	@Ok("httl:qrtz.crontriggers_manager")
	@RequiresPermissions("httl:read:crontriggers_manager")
	public void crontriggers_manager() {
	}
}