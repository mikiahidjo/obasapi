package domain.users

import play.api.libs.json.Json

case class UserApplicationResult(
                                 userApplicationResultId:String,
                                 description:String
                                )
object UserApplicationResult{
  implicit val UserApplicationResultFmt = Json.format[UserApplicationResult]
}
