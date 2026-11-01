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