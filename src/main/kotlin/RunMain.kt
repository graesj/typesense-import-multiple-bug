import org.typesense.api.Client
import org.typesense.api.Configuration
import org.typesense.api.FieldTypes
import org.typesense.model.*
import org.typesense.resources.Node
import java.time.Duration


fun main() {
    val nodes = listOf<Node>(
        Node(
            "http", "localhost", "8108"
        )
    )
    val configuration = Configuration(nodes, Duration.ofSeconds(5), "xyz")
    val client = Client(configuration)

    val collectionSchema = CollectionSchema().apply {
        name = "countries"
        fields = listOf(
            Field().name("countryName").type(FieldTypes.STRING),
            Field().name("gdp").type(FieldTypes.INT64)
        )
    }
    client.collections().create(collectionSchema)

    val queryParameters = ImportDocumentsParameters().apply {
        action = "create"
    }
    val documentList = "{\"countryName\": \"India\", \"gdp\": 5215}\n" +
            "{\"countryName\": \"Iran\", \"gdp\": 5215}"

    val bulkImportResult = client.collections("countries").documents().import_(documentList, queryParameters)
    println(bulkImportResult)


}