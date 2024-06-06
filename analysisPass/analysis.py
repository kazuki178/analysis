# モジュールのインポート
import time 
import getpass
from itertools import product 

target = getpass.getpass(prompt='パスワードを入力してください: ')# パスワードを入力

chars = '0123456789abcdefghijklmnopqrstuvwxyz'# すべての文字

# パスワード解析関数
def check(text,repeat):
    passwords = product(text,repeat=repeat) # 与えられた文字から生成可能な全てのパスワードを生成
    for i, password in enumerate(passwords): # 各パスワードをfor文で総なめ
        print('\033[32m'+str(i)+' 回目の処理 : '+''.join(password)+'\033[0m') #実行回数と生成した候補パスワードを表示
        if ''.join(password)==target: # 生成したパスワードが目標のパスワードと一致するか確認
            return ''.join(password) #一致した場合のみパスワードをreturn 
        
# 解析実行判断関数
def yes_no_input():
    while True:
        choice = input('パスワードの解析を始めますか? [yes/no]: ').lower()
        if choice == 'yes':# yesなら解析実行
            return True
        else:
            return False
        

if yes_no_input():
    start = time.time() # 時間(s)計測開始
    pw = check(chars,3) # パスワード解析関数の呼び出し 第二引数は解析する文字数
    if pw is None:
        print('失敗')
    else:
        print()
        print('パスワードが見つかりました ----->>>',pw)
        finish = time.time()-start #　解析時間(s)の計算
        print(finish,'秒' ,'=', finish/60,'分')
else:
    print('program end.')
