QUnit.module("Római szám konverter tesztelése");

QUnit.test("Alapszimbólumok konvertálása", function(assert) {
    assert.equal(toRoman(1), "I", "1 -> I");
    assert.equal(toRoman(5), "V", "5 -> V");
    assert.equal(toRoman(10), "X", "10 -> X");
    assert.equal(toRoman(50), "L", "50 -> L");
    assert.equal(toRoman(100), "C", "100 -> C");
    assert.equal(toRoman(500), "D", "500 -> D");
    assert.equal(toRoman(1000), "M", "1000 -> M");
});

QUnit.test("Összeadó szabályok", function(assert) {
    assert.equal(toRoman(2), "II", "2 -> II");
    assert.equal(toRoman(3), "III", "3 -> III");
    assert.equal(toRoman(6), "VI", "6 -> VI");
    assert.equal(toRoman(8), "VIII", "8 -> VIII");
    assert.equal(toRoman(15), "XV", "15 -> XV");
    assert.equal(toRoman(20), "XX", "20 -> XX");
});

QUnit.test("Kivonásos szabályok", function(assert) {
    assert.equal(toRoman(4), "IV", "4 -> IV");
    assert.equal(toRoman(9), "IX", "9 -> IX");
    assert.equal(toRoman(40), "XL", "40 -> XL");
    assert.equal(toRoman(90), "XC", "90 -> XC");
    assert.equal(toRoman(400), "CD", "400 -> CD");
    assert.equal(toRoman(900), "CM", "900 -> CM");
});

QUnit.test("Összetett számok", function(assert) {
    assert.equal(toRoman(14), "XIV", "14 -> XIV");
    assert.equal(toRoman(44), "XLIV", "44 -> XLIV");
    assert.equal(toRoman(99), "XCIX", "99 -> XCIX");
    assert.equal(toRoman(444), "CDXLIV", "444 -> CDXLIV");
    assert.equal(toRoman(1994), "MCMXCIV", "1994 -> MCMXCIV");
    assert.equal(toRoman(2026), "MMXXVI", "2026 -> MMXXVI");
    assert.equal(toRoman(3999), "MMMCMXCIX", "3999 -> MMMCMXCIX");
});