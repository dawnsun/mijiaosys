package com.mijiaokj.sys.web.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.mijiaokj.sys.domain.SysRole;
import com.mijiaokj.sys.domain.SysUser;

/**
 * @author sunchenguang
 * @mail scg16@126.com
 * security用户
 */
public class MijiaoSysUserDetails  implements UserDetails {

	private static final long serialVersionUID = -2283085216557756669L;

	private List<SysRole> roles;
	private SysUser sysUser;
	 public MijiaoSysUserDetails(SysUser sysUser, List<SysRole> roles){
		 this.sysUser = sysUser;
	        this.roles = roles;
	    }
	 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(roles == null || roles.size() <1){
            return AuthorityUtils.commaSeparatedStringToAuthorityList("");
        }
        StringBuilder commaBuilder = new StringBuilder();
        for(SysRole role : roles){
            commaBuilder.append(role.getRoleName()).append(",");
        }
        String authorities = commaBuilder.substring(0,commaBuilder.length()-1);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//账户没有被锁定
	@Override
	public boolean isAccountNonLocked() {
		return sysUser.getUserStatus();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//账户是否有效 
	@Override
	public boolean isEnabled() {
		return sysUser.getUserStatus();
	}

	@Override
	public String getPassword() {
		return sysUser.getPassword();
	}

	@Override
	public String getUsername() {
		return sysUser.getUsername();
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

}
