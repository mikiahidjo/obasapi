package repository.users.impl.cassandra.tables

import com.outworkers.phantom.dsl._
import com.outworkers.phantom.streams._
import domain.users.UserPassword

import scala.concurrent.Future

abstract class ContactTypeTable extends Table[ContactTypeTable, UserPassword]{

  object userId extends StringColumn with PartitionKey

  object password extends StringColumn



}

abstract class ContactTypeTableImpl extends ContactTypeTable with RootConnector {

  override lazy val tableName = "mailapis"

  def saveEntity(entity: UserPassword): Future[ResultSet] = {
    insert
      .value(_.userId, entity.userId)
      .value(_.password, entity.password)
      .future()
  }

  def getEntity(userId: String): Future[Option[UserPassword]] = {
    select
      .where(_.userId eqs userId)
      .one()
  }

  def getEntities: Future[Seq[UserPassword]] = {
    select
      .fetchEnumerator() run Iteratee.collect()
  }

  def deleteEntity(userId: String): Future[ResultSet] = {
    delete
      .where(_.userId eqs userId)
      .future()
  }
}
