package domain.util.generic

import play.api.libs.json.Json

case class GenericStatus(
                   id: String,
                   name: String,
                   description: String = ""
                 )

object GenericStatus {
  implicit val genericStatusFmt = Json.format[GenericStatus]
  def build(name: String) = GenericStatus("", name)
}

