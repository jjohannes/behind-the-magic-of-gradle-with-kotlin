apply {
    plugin("base")
    plugin<CountAllTheThingsPlugin>()
}

repositories {
    jcenter()
    google()
}

dependencies {
    "allThings"(project(":moreThings"))
    "androidThings"(project(":moreThings"))
}

val listThings by tasks.getting(ListAllThingsTask::class) {
    list = (1..20).toList()
}
