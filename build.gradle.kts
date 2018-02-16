apply {
    plugin("base")
    plugin<CountAllTheThingsPlugin>()
}

configurations {
    "allThings" {}
}

dependencies {
    "allThings"(project(":moreThings"))
}

val listThings by tasks.getting(ListAllThingsTask::class) {
    list = (1..20).toList()
}

val countThings by tasks.getting(CountAllThingsTask::class) {
    moreListFiles = configurations["allThings"]
}
