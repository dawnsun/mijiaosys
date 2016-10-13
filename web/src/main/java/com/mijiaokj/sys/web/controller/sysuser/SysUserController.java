package com.mijiaokj.sys.web.controller.sysuser;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mijiaokj.sys.dal.repository.query.SysUserCriteria;
import com.mijiaokj.sys.domain.SysUser;
import com.mijiaokj.sys.service.SysUserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * @ClassName: LoginController
 * @Description: TODO 用户信息操作Controller，提供swagger2访问：/swagger-ui.html
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月13日
 *
 */
@Controller
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;

	@ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的sysUser信息来更新用户详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
	@ApiImplicitParam(name = "user", value = "用户详细实体sysUser", required = true, dataType = "SysUser") })
	@RequestMapping(value = "/sys/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String edit(@RequestBody SysUser sysUser) {
		sysUserService.createSysUser(sysUser);
		return "edit";
	}

	@ApiOperation(value = "新增用户", notes = "根据SysUser对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体sysUser", required = true, dataType = "SysUser")
	@RequestMapping(value = "/sys/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(@RequestBody SysUser sysUser) {
		sysUserService.createSysUser(sysUser);
		return "add";
	}

	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	@RequestMapping(value = "/sys/view", method = RequestMethod.GET)
	@ResponseBody
	public String view(@PathVariable Long id) {
		return "view";
	}

	@ApiOperation(value = "获取用户列表", notes = "")
	@RequestMapping(value = "/sys/list", method = RequestMethod.GET)
	public String list() {
		return "user/list";
	}

	@ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		return "success";
	}
	
	/**
	 * 返回分页数据页面解析
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sys/page.do", method = RequestMethod.GET)
	@ResponseBody
	public String getPageData(HttpServletRequest request){
		SysUserCriteria criteria = new SysUserCriteria();
		String start=request.getParameter("start");
		if(StringUtils.isBlank(start)){
			start="0";
		}
		String limit=request.getParameter("limit");
		if(StringUtils.isBlank(limit)){
			limit="10";
		}
		criteria.setPageSize(Integer.parseInt(limit));
		criteria.setStartRow(Integer.parseInt(start));
		return JSON.toJSONString(sysUserService.querySysUserByCriteria(criteria));
	}
}
