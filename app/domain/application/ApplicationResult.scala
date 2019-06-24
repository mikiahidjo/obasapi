package domain.application

import akka.http.scaladsl.model.DateTime
import play.api.libs.json.Json

case class ApplicationResult(
                             applicationResultId:String,
                             description:String,
                             date:DateTime
                             )
object ApplicationResult{
  implicit val applicationResultFmt = Json.format[ApplicationResult]
}
