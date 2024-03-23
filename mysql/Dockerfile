FROM mysql:latest

# rootユーザーに変更
USER root

# シェルスクリプトをイメージ内にコピー
COPY ./mysql/initdb.d/ /docker-entrypoint-initdb.d

# シェルスクリプトに実行権限を追加
RUN chmod +x /docker-entrypoint-initdb.d/entrypoint.sh

# イメージからコンテナを作成・起動する際に実行されるコマンド
ENTRYPOINT ["/docker-entrypoint-initdb.d/entrypoint.sh"]
