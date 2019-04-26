package models.aplication

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name="person")
class Person : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //HIBERNATE GENERATES ID
    var id:Long = 0

    @Column(name = "first_name", nullable = false, length = 80)
    var firstName:String = ""

    @Column(name = "last_name", nullable = false, length = 80)
    var lastName:String = ""

    @Column(nullable = false, length = 100)
    var address:String = ""

    @Column(nullable = false, length = 6)
    var gender:String = ""


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (address != other.address) return false
        if (gender != other.gender) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + gender.hashCode()
        return result
    }


}