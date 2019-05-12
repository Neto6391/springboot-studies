package com.neto6391.restappdb.data.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "user")
open class User : UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id:Long = 0L

    @Column(name = "user_name", unique = true)
    var userName:String = ""

    @Column(name = "full_name")
    var fullName:String = ""

    @Column(name = "password")
    var passwrd:String = ""

    @Column(name = "account_non_expired")
    var accountNonExpired:Boolean = false

    @Column(name = "account_non_locked")
    var accountNonLocked:Boolean = false

    @Column(name = "credentials_non_expired")
    var credentialsNonExpired:Boolean = false

    @Column(name = "enabled")
    var enabled:Boolean = false

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permission", joinColumns = [JoinColumn(name = "id_user")],
            inverseJoinColumns = [JoinColumn(name = "id_permission")])
    var permissions:MutableList<Permission> = mutableListOf<Permission>()


    fun getRoles():List<String> {
        val roles = mutableListOf<String>()
        for (permission:Permission in permissions) {
            roles.add(permission.description)
        }

        return roles
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return permissions
    }

    override fun isEnabled(): Boolean {
        return enabled
    }

    override fun getUsername(): String {
       return userName
    }

    override fun isCredentialsNonExpired(): Boolean {
        return credentialsNonExpired
    }

    override fun getPassword(): String {
        return passwrd
    }

    override fun isAccountNonExpired(): Boolean {
        return accountNonExpired
    }

    override fun isAccountNonLocked(): Boolean {
        return accountNonLocked
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (id != other.id) return false
        if (userName != other.userName) return false
        if (fullName != other.fullName) return false
        if (passwrd != other.passwrd) return false
        if (accountNonExpired != other.accountNonExpired) return false
        if (accountNonLocked != other.accountNonLocked) return false
        if (credentialsNonExpired != other.credentialsNonExpired) return false
        if (enabled != other.enabled) return false
        if (permissions != other.permissions) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + userName.hashCode()
        result = 31 * result + fullName.hashCode()
        result = 31 * result + passwrd.hashCode()
        result = 31 * result + accountNonExpired.hashCode()
        result = 31 * result + accountNonLocked.hashCode()
        result = 31 * result + credentialsNonExpired.hashCode()
        result = 31 * result + enabled.hashCode()
        result = 31 * result + permissions.hashCode()
        return result
    }


}