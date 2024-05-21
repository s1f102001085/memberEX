var currentPage = 1;
// ページング機能を実装する関数
function displayPage(page) {
    // 表示するページの範囲を計算
    var startIndex = (page - 1) * 14;
    var endIndex = startIndex + 14;
    // 表示する要素を取得
    var items = document.querySelectorAll('[id^=member]');
    // 表示する要素を更新
    items.forEach(function(item, index) {
        if (index >= startIndex && index < endIndex) {
            item.classList.remove('hidden');// 表示する
        } else {
			item.classList.add('hidden'); // 非表示にする
        }
    });
}

// 初期表示
displayPage(1);

// 前のページを表示するボタン
document.getElementById('prevButton').addEventListener('click', function() {
    if (currentPage > 1) { // もし現在のページが1より大きい場合のみ
        currentPage--;
        displayPage(currentPage);
    }
});

// 次のページを表示するボタン
document.getElementById('nextButton').addEventListener('click', function() {
	var totalPages = Math.ceil(document.querySelectorAll('[id^=member]').length / 14);
    if (currentPage < totalPages) { // もし現在のページが最大ページ未満の場合のみ
        currentPage++;
        displayPage(currentPage);
    }
});