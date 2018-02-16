apply {
    plugin("base")
    plugin<CountAllTheThingsPlugin>()
}

val listThings by tasks.getting(ListAllThingsTask::class) {
    list = (1..11).toList()
}

dependencies {
    "androidThings"("com.android.support:support-compat:27.0.2")
    "allThings"("com.google.guava:guava:24.+")
}