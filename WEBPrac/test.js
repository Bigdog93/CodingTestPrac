var teststr = 'https://test.com/thisisid';

var resStr = teststr.substring(teststr.lastIndexOf('/') + 1);
console.log(resStr);