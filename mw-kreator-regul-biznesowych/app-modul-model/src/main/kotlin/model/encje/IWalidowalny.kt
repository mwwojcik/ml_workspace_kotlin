package model.encje

interface IWalidowalny {
    fun waliduj():List<String>
    fun zglosBladBrakuOkreslonegoTypu(nazwa:String)="Pole $nazwa wymaga określenia typu"
}