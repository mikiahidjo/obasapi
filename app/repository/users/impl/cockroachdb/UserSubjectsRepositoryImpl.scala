package repository.users.impl.cockroachdb

import domain.users.UserSubjects
import repository.users.impl.cockroachdb.tables.UserSubjectsTable
import repository.users.UserSubjectsRepository

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class UserSubjectsRepositoryImpl  extends UserSubjectsRepository{

  override def saveEntity(entity: UserSubjects): Future[Boolean] = {
    UserSubjectsTable.saveEntity(entity).map(value=> value.equals(entity))
  }

  override def getEntities: Future[Seq[UserSubjects]] = {
    UserSubjectsTable.getEntities
  }

  override def getEntity(userContactId: String): Future[Option[UserSubjects]] = {
    UserSubjectsTable.getEntity(userContactId)
  }

  override def deleteEntity(entity: UserSubjects): Future[Boolean] = {
    UserSubjectsTable.deleteEntity(entity.userSubjectId)map(value=> value.isValidInt)
  }

  override def createTable: Future[Boolean] = {
    Future.successful(UserSubjectsTable.createTable)
  }
}
