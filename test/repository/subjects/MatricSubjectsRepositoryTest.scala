package repository.subjects

import domain.subjects.MatricSubjects
import org.scalatest.FunSuite

import scala.concurrent.Await
import scala.concurrent.duration._

class MatricSubjectsRepositoryTest extends FunSuite {

  val entity = MatricSubjects("123",null,"Bachelor","Term 4 2020")
  val repository = MatricSubjectsRepository
  test("createEntity"){
    val result = Await.result(repository.apply.saveEntity(entity), 2 minutes)
    assert(result)

  }

  test("readEntity"){
    val result = Await.result(repository.apply.getEntity(entity.subjectCode), 2 minutes)
    assert(result.head.subjectCode==entity.subjectCode)
  }

  test("createEntities"){
    val result = Await.result(repository.apply.getEntities, 2 minutes)
    assert(result.nonEmpty)
  }

  test("updateEntities"){
    val updatedEntity=entity.copy(name = "6 Browning RD")
    Await.result(repository.apply.saveEntity(updatedEntity), 2 minutes)
    val result = Await.result(repository.apply.getEntity(entity.subjectCode), 2 minutes)
    assert(result.head. name==updatedEntity. name)
  }


  test("deleteEntities"){
    Await.result(repository.apply.deleteEntity(entity), 2 minutes)
    val result = Await.result(repository.apply.getEntity(entity.subjectCode), 2 minutes)
    assert(result.isEmpty)
  }
  
}