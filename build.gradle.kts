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
    "allThings"("com.android.support:support-compat:27.0.2")
}

val listThings by tasks.getting(ListAllThingsTask::class) {
    list = (1..20).toList()
}
