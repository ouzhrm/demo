最字串问题都可以用滑动窗口（本质快慢指针）解决。
滑动窗口有模板：https://labuladong.gitbook.io/algo/bi-du-wen-zhang/hua-dong-chuang-kou-ji-qiao-jin-jie

滑动窗口概要模板：
int left = 0, right = 0;

while (right < s.size()) {`
    // 增大窗口
    window.add(s[right]);
    right++;

    while (window needs shrink) {
        // 缩小窗口
        window.remove(s[left]);
        left++;
    }
}
