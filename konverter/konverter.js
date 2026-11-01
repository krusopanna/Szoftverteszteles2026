const ROMAN_MAPPING = [
    { value: 1000, symbol: "M" },
    { value: 500,  symbol: "D" },
    { value: 100,  symbol: "C" },
    { value: 50,   symbol: "L" },
    { value: 10,   symbol: "X" },
    { value: 5,    symbol: "V" },
    { value: 1,    symbol: "I" }
];

function toRoman(num) {
    let result = "";
    for (const item of ROMAN_MAPPING) {
        while (num >= item.value) {
            result += item.symbol;
            num -= item.value;
        }
    }
    return result;
}