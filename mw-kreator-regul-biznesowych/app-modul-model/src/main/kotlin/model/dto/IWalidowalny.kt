package model.dto


interface IWalidowalny {
    fun waliduj():List<String>
    fun zglosBladBrakuOkreslonegoTypu(nazwa:String)="Pole $nazwa wymaga określenia typu"
    fun zglosBladBrakuMapowaniaParametruWy(nazwa:String)="Brak mapowania parametru WY $nazwa"
}