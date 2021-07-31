package grails4.project

import grails.gorm.transactions.Transactional
import org.apache.shiro.authc.credential.PasswordService

@Transactional
class BootstrapService {

//    PasswordService credentialMatcher
    PasswordService credentialMatcher



    void addUsers() {

        println "1 user count ${ShiroUser.count}"
        println "1 role count ${ShiroRole.count}"

        if(ShiroUser.count > 0) return

        def userRole = new ShiroRole(name: "User")
        def normalUser = new ShiroUser(username: "dilbert", passwordHash: credentialMatcher.encryptPassword("password"))
        normalUser.addToRoles(userRole)
        normalUser.addToPermissions("team:show,index,read")
        normalUser.save()
        assert credentialMatcher.passwordsMatch('password', normalUser.passwordHash)

        // Users for the TestController.
        def testRole = new ShiroRole(name: "test")
        testRole.addToPermissions("team:*")

        def testUser1 = new ShiroUser(username: "test1", passwordHash: credentialMatcher.encryptPassword("test1"))
        testUser1.addToRoles(testRole)
        testUser1.addToRoles(userRole)
        testUser1.addToPermissions("custom:read,write")

        testUser1.save()


        println "2 user count ${ShiroUser.count}"
        println "2 role count ${ShiroRole.count}"

        assert credentialMatcher.passwordsMatch('test1', testUser1.passwordHash)

    }
}
