import { Regula } from './model';

export const REGULY: Regula[] = [
  { id: 1,
  wersja: 2,
  kod: "RS-001",
  tresc: "Jeśli data1 jest równa '01-01-2000' wtedy wyświetlaj komunikat \"Podana data jest równa 01-01-2000\" ." ,
  parametry:[],
  wywolaniaRegul:[],
  "sekwencja": {
    "postacKanoniczna": "Jeśli data1 jest równa '01-01-2000' wtedy wyświetlaj komunikat KOMUNIKAT1 .",
    "zdaniePierwotne": "Jeśli data1 jest równa '01-01-2000' wtedy wyświetlaj komunikat KOMUNIKAT1 .",
    "tokeny": [
        "Jeśli",
        "data1",
        "jest",
        "równa",
        "'01-01-2000'",
        "wtedy",
        "wyświetlaj",
        "komunikat",
        "KOMUNIKAT1",
        "."
    ],
    "rozpoznaneTokeny": [
        {
            "kategoria": null,
            "lp": 1,
            "wartosc": "Jeśli ",
            "typ": "POCZATEK_REGULY",
            "prob": 0.19358072642932103
        },
        {
            "kategoria": null,
            "lp": 2,
            "wartosc": "data1 ",
            "typ": "LEWOSTRONNY_OPERAND_WARUNKU",
            "prob": 0.1845057576128071
        },
        {
            "kategoria": "==",
            "lp": 3,
            "wartosc": "jest równa ",
            "typ": "OPETATOR_POROWNANIA",
            "prob": 0.19175765455936755
        },
        {
            "kategoria": null,
            "lp": 4,
            "wartosc": "'01-01-2000' ",
            "typ": "PRAWOSTRONNY_OPERAND_WARUNKU",
            "prob": 0.15456750082896537
        },
        {
            "kategoria": null,
            "lp": 5,
            "wartosc": "wtedy ",
            "typ": "KONIEC_REGULY",
            "prob": 0.18938611298314553
        },
        {
            "kategoria": "WYSWIETL_KOMUNIKAT",
            "lp": 6,
            "wartosc": "wyświetlaj komunikat ",
            "typ": "AKCJA",
            "prob": 0.18995680026582853
        },
        {
            "kategoria": null,
            "lp": 7,
            "wartosc": "KOMUNIKAT1 ",
            "typ": "PARAMETR_AKCJI",
            "prob": 0.17290652945075932
        }
    ]
}
},
{
    "id": 2,
    "wersja": 2,
    "kod": "RS-002",
    "tresc": "Jeśli data nie jest większa od '01-01-2000' wtedy waliduj regułę RS-001 .",
    "sekwencja": {
        "postacKanoniczna": "Jeśli data nie jest większa od '01-01-2000' wtedy waliduj regułę RS-001 .",
        "zdaniePierwotne": "Jeśli data nie jest większa od '01-01-2000' wtedy waliduj regułę RS-001 .",
        "tokeny": [
            "Jeśli",
            "data",
            "nie",
            "jest",
            "większa",
            "od",
            "'01-01-2000'",
            "wtedy",
            "waliduj",
            "regułę",
            "RS-001",
            "."
        ],
        "rozpoznaneTokeny": [
            {
                "kategoria": null,
                "lp": 1,
                "wartosc": "Jeśli ",
                "typ": "POCZATEK_REGULY",
                "prob": 0.19329940876322138
            },
            {
                "kategoria": null,
                "lp": 2,
                "wartosc": "data ",
                "typ": "LEWOSTRONNY_OPERAND_WARUNKU",
                "prob": 0.1810376118580793
            },
            {
                "kategoria": "<=",
                "lp": 3,
                "wartosc": "nie jest większa od ",
                "typ": "OPETATOR_POROWNANIA",
                "prob": 0.18858047834186953
            },
            {
                "kategoria": null,
                "lp": 4,
                "wartosc": "'01-01-2000' ",
                "typ": "PRAWOSTRONNY_OPERAND_WARUNKU",
                "prob": 0.19275913502254302
            },
            {
                "kategoria": null,
                "lp": 5,
                "wartosc": "wtedy ",
                "typ": "KONIEC_REGULY",
                "prob": 0.18865564158100814
            },
            {
                "kategoria": "SPRAWDZ_REGULE",
                "lp": 6,
                "wartosc": "waliduj regułę ",
                "typ": "AKCJA",
                "prob": 0.19266861143321734
            },
            {
                "kategoria": null,
                "lp": 7,
                "wartosc": "RS-001 ",
                "typ": "PARAMETR_AKCJI",
                "prob": 0.17290652945075932
            }
        ]
    },
    "parametry": [
        {
            "id": 3,
            "wersja": 2,
            "nazwa": "data ",
            "typ": "Data",
            "wartoscDomyslna": null,
            "czyUsuwalny": 0
        },
        {
            "id": 4,
            "wersja": 2,
            "nazwa": "param0",
            "typ": "Data",
            "wartoscDomyslna": "'01-01-2000' ",
            "czyUsuwalny": 0
        }
    ],
    "wywolaniaRegul": [
        {
            "id": 1,
            "wersja": 2,
            "kodRegulyWolajacej": "RS-002",
            "kodRegulyWolanej": "RS-001",
            "parametry": [
                {
                    "id": 1,
                    "wersja": 3,
                    "nazwaParametruRegulyWolajacej": "data ",
                    "nazwaParametruRegulyWolanej": "data1 "
                },
                {
                    "id": 2,
                    "wersja": 3,
                    "nazwaParametruRegulyWolajacej": "data ",
                    "nazwaParametruRegulyWolanej": "param0"
                }
            ]
        }
    ]
},

]