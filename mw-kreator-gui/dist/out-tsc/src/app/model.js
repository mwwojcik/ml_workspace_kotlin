import * as tslib_1 from "tslib";
/**
 *
 
 
open  class ObiektBazowy(){
    var id:Long?=null
    var wersja:Long?=null
}

data class Parametr(
        val nazwa: String
        , var typ: String? = null
        , val wartoscDomyslna: String? = ""
        , val czyUsuwalny:Int=0
) : ObiektBazowy(),IWalidowalny{}

class ParametrWywolaniaReguly( var nazwaParametruRegulyWolajacej:String=""
                              ,var nazwaParametruRegulyWolanej  :String )

                              {}

   data class Regula(
        val kod: String
        , var tresc: String
        , val sekwencja: Sekwencja
        , var parametry: MutableList<Parametr> = mutableListOf()
        , var wywolaniaRegul: MutableList<WywolanieReguly> = mutableListOf()
    )
class WywolanieReguly(val kodRegulyWolajacej: String
                      , val kodRegulyWolanej: String
                      , var parametry: MutableList<ParametrWywolaniaReguly> = mutableListOf()


                      class Sekwencja(val zdaniePierwotne:String, val tokeny:Array<String>,
                val rozpoznaneTokeny:MutableList<RozpoznanyToken>
                = mutableListOf<RozpoznanyToken>()) {


                    class RozpoznanyToken(val lp:Int,val wartosc:String,val typ:RodzajTokenaEnum,val prob:Double) {

    var kategoria:String?=null

)
 */
var ObiektBazowy = /** @class */ (function () {
    function ObiektBazowy() {
    }
    return ObiektBazowy;
}());
export { ObiektBazowy };
var RegulaBiznesowa = /** @class */ (function () {
    function RegulaBiznesowa() {
    }
    return RegulaBiznesowa;
}());
export { RegulaBiznesowa };
var Parametr = /** @class */ (function (_super) {
    tslib_1.__extends(Parametr, _super);
    function Parametr() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.czyUsuwalny = 0;
        return _this;
    }
    return Parametr;
}(ObiektBazowy));
export { Parametr };
var ParametrWywolaniaReguly = /** @class */ (function (_super) {
    tslib_1.__extends(ParametrWywolaniaReguly, _super);
    function ParametrWywolaniaReguly() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return ParametrWywolaniaReguly;
}(ObiektBazowy));
export { ParametrWywolaniaReguly };
var Regula = /** @class */ (function (_super) {
    tslib_1.__extends(Regula, _super);
    function Regula() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return Regula;
}(ObiektBazowy));
export { Regula };
var Sekwencja = /** @class */ (function () {
    function Sekwencja() {
    }
    return Sekwencja;
}());
var RozpoznanyToken = /** @class */ (function () {
    function RozpoznanyToken() {
    }
    return RozpoznanyToken;
}());
var WywolanieReguly = /** @class */ (function (_super) {
    tslib_1.__extends(WywolanieReguly, _super);
    function WywolanieReguly() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return WywolanieReguly;
}(ObiektBazowy));
//# sourceMappingURL=model.js.map