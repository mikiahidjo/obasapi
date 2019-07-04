package services.demographics

import domain.demographics.Roles
import org.scalatest.FunSuite

import scala.concurrent.Await
import scala.concurrent.duration._

class RolesServicesTest extends FunSuite {

  val entity = Roles("1","Male")
  val service = RoleService
  test("createEntity"){
    val result = Await.result(service.apply.saveEntity(entity), 2 minutes)
    assert(result)

  }

  test("readEntity"){
    val result = Await.result(service.apply.getEntity(entity.id), 2 minutes)
    assert(result.head.id==entity.id)
  }

  test("createEntities"){
    val result = Await.result(service.apply.getEntities, 2 minutes)
    assert(result.nonEmpty)
  }

  test("updateEntities"){
    val updatedEntity=entity.copy(roleName = "Female")
    Await.result(service.apply.saveEntity(updatedEntity), 2 minutes)
    val result = Await.result(service.apply.getEntity(entity.id), 2 minutes)
    assert(result.head.roleName==updatedEntity.roleName)
  }


  test("deleteEntities"){
    Await.result(service.apply.deleteEntity(entity), 2 minutes)
    val result = Await.result(service.apply.getEntity(entity.id), 2 minutes)
    assert(result.isEmpty)

  }

}
