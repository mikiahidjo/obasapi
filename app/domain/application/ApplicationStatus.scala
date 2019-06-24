package domain.application

import akka.http.javadsl.model.DateTime
import play.api.libs.json.Json

class ApplicationStatus (
                          applicationStatusId:String,
                          description:String,
                          date:DateTime,
                        )
object ApplicationStatus{
  implicit val applicationStatusFmt = Json.format[ApplicationStatus]

}

