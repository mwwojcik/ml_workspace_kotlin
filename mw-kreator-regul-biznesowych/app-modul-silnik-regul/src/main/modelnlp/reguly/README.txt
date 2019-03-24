    Skanujemy katalog $katalogRegul w poszukiwaniu wszystkich plików reguł *.reg
     * Iterujemy przez znalezione zbiory
     *  Dla każdego elementu dokonujemy split("_")
     *  tab[0]->mówi nam o rodzaju modelu {encje,kategoryzacja}
     *  encje_reguly_probka_uczaca.reg ->encje_reguly_model.bin
     *  kategoryzacja_reguly_probka_uczaca-.reg>kategoryzacja_model.bin

     Pliki trafiają modelnlp/bin lub w zależności od definicji parametru:


val wytrenujModel by tasks.getting(WytrenujModelTask::class){
    katalogModeluOUT= File("src/main/resources/modelnlp").toPath()
}

